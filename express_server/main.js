const express = require("express");
const cors = require("cors");
const router = require("./router/router");
const app = express();
app.use(cors());
app.use(express.urlencoded({ extended: false }));
app.use(express.json());
// 引用router
app.use(router);
// 挂载出错的中间件
const errorHandler = () => {
    return (err, req, res, next) => {
      res.status(500).json({
        error: err.message,
      });
    };
  };
app.use(errorHandler());

app.listen(8081, () => {
  console.log("server running");
});
