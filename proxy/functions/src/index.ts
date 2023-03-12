// import * as functions from "firebase-functions";
// import express, { Request, Response, ErrorRequestHandler } from "express";
// import https from "https";
// import dotenv from "dotenv";
// import { createProxyMiddleware } from "http-proxy-middleware";
// import winston from "winston";
// import wdrf from "winston-daily-rotate-file";
// import { Options } from "http-proxy-middleware";
// import { type OnErrorCallback } from "http-proxy-middleware/dist/types";

// dotenv.config();

// const transport = new winston.transports.DailyRotateFile({
//   filename: "application-%DATE%.log",
//   datePattern: "YYYY-MM-DD-HH",
//   zippedArchive: true,
//   maxSize: "20m",
//   maxFiles: "14d",
// });

// const logger = winston.createLogger({
//   transports: [transport],
// });

// export const onProxyReq = (proxyReq: any, req: Request, res: Response) => {
//   proxyReq.setHeader("X-Api-Key", process.env.NEWS_API_KEY);
// };

// const errorRequestHandler: OnErrorCallback = (err, req, res, target) => {
//   res.writeHead(500, {
//     "Content-Type": "text/plain",
//   });
//   res.end("Something went wrong. And we are reporting a custom error message.");
// };

// export const onError = errorRequestHandler;

// export const proxyOptions: Options = {
//   target: process.env.NEW_API_AUTHORITY,
//   changeOrigin: true,
//   onProxyReq: onProxyReq,
//   onError: onError,
// };

// // export default functions.region("asia-east2").https.onRequest((req, res) => {
// //   createProxyMiddleware({
// //     target: process.env.NEW_API_AUTHORITY,
// //     changeOrigin: true,
// //     onProxyReq: onProxyReq,
// //     onError: onError,
// //   })
// // });

// export default functions.region("asia-east2").https.onRequest(
//   createProxyMiddleware({
//     target: process.env.NEW_API_AUTHORITY,
//     changeOrigin: true,
//     onProxyReq: onProxyReq,
//     onError: onError,
//   })
// );

import * as functions from "firebase-functions";
// import createError from "http-errors";
import express from "express";
import path from "path";
import cookieParser from "cookie-parser";
import dotenv from "dotenv";
import helmet from "helmet";
import { createProxyMiddleware, Options } from "http-proxy-middleware";
import winston from "winston";
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import "winston-daily-rotate-file";
import {
  LogProviderCallback,
  OnErrorCallback,
  OnProxyReqCallback,
} from "http-proxy-middleware/dist/types";

const transport = new winston.transports.DailyRotateFile({
  filename: "application-%DATE%.log",
  datePattern: "YYYY-MM-DD-HH",
  zippedArchive: true,
  maxSize: "20m",
  maxFiles: "14d",
});

// transport.on("rotate", function(oldFilename, newFilename) {
//   // do something fun
// });

const logger = winston.createLogger({
  transports: [transport],
});

dotenv.config();

const app = express();
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, "public")));
app.use(helmet());

// eslint-disable-next-line @typescript-eslint/no-unused-vars
const logProvider: LogProviderCallback = (provider) => {
  // replace the default console log provider.
  return logger;
};

// eslint-disable-next-line @typescript-eslint/no-unused-vars
const onProxyReq: OnProxyReqCallback = (proxyReq, req, res) => {
  // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
  proxyReq.setHeader("X-Api-Key", process.env.NEWS_API_KEY!);
};

const errorRequestHandler: OnErrorCallback = (err, req, res, target) => {
  res.writeHead(500, {
    "Content-Type": "text/plain",
  });
  res.end("Something went wrong. And we are reporting a custom error message.");
};

export const proxyOptions: Options = {
  target: process.env.NEW_API_AUTHORITY,
  changeOrigin: true,
  onProxyReq: onProxyReq,
  logProvider: logProvider,
  onError: errorRequestHandler,
};

app.use("/", createProxyMiddleware(proxyOptions));
// error handler
// app.use((err, req, res, next) => {
//   // set locals, only providing error in development
//   res.locals.message = err.message;
//   res.locals.error = req.app.get("env") === "development" ? err : {};

//   // render the error page
//   res.status(err.status || 500);
//   res.render("error");
// });

export default functions.region("asia-east2").https.onRequest((req, res) => {
  res.json({status: "ok"});
});
