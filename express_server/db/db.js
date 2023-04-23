const mysql = require("mysql");
const { host, user, password, database } = require("../config/config");
const db = mysql.createPool({
  host, //数据库的IP地址
  user, //登录数据库的账号
  password, //登录数据库的密码
  database, //指定要操作那个数据库
});
module.exports = db;
