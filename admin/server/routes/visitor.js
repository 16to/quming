// /api/visitor
const express = require('express');
const db = require('../core/db');
const utils = require('../core/utils');

const router = express.Router();

router.get('/', (req, res) => {
  const con = [];
  con['1'] = 1;
  if (req.query.search) {
    con.like = `client like '%${req.query.search}%'`;
  }
  con.orderBy = 'visitortime desc';
  db.Select('qm_visitor', con, (err, response) => {
    res.send(response);
  });
});

// 添加访问记录
router.post('/', (req, res) => {
  const insertData = [];
  insertData.client = req.body.client;
  insertData.visitortime = Date.parse(new Date());
  // 获取访问ip
  insertData.visitorip = utils.getClientIp(req);
  db.Insert('qm_visitor', insertData, (err, response) => {
    res.send(response);
  });
});

module.exports = router;
