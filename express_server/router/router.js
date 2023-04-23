const express = require('express');
const commit = require('../api/commit');
const todayMorality = require('../api/todayMorality');
const totalMorality = require('../api/totalMorality');
const router = express.Router();
// 提交
router.post("/api/commit",commit) 
// 查看今日功德
router.post("/api/todayMorality",todayMorality)
// 查看总功德
router.post("/api/totalMorality",totalMorality)
module.exports = router;