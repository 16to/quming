// eslint-disable-next-line eslint-comments/disable-enable-pair
/* eslint-disable no-console */

const express = require('express');
const http = require('http');
const path = require('path');
const bodyparser = require('body-parser');
const proxy = require('http-proxy-middleware');
const cookieParser = require('cookie-parser');
const compression = require('compression');

// const route = require('./route');
// router
const tableRouter = require('./routes/table');
const loginRouter = require('./routes/login');
const accountRouter = require('./routes/account');
const articleRouter = require('./routes/article');
const visitorRouter = require('./routes/visitor');
const sysconfigRouter = require('./routes/sysconfig');
const uploadRouter = require('./routes/upload');


// node server port
const PORT = 8000;
const app = express();
app.use(bodyparser.json());
app.use(cookieParser());
app.use(compression());
app.all('*', function (req, res, next) {
  //设置允许跨域的域名，*代表允许任意域名跨域
  res.header("Access-Control-Allow-Origin", req.headers.origin || '*');
  //允许的header类型
  res.header("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With");
  //跨域允许的请求方式 
  res.header("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
  // 可以带cookies
  res.header("Access-Control-Allow-Credentials", true);
  if (req.method == 'OPTIONS') {
    res.sendStatus(200);
  } else {
    next();
  }
});
const httpServer = http.createServer(app);

// set api
app.use('/api/table', tableRouter);
app.use('/api/login', loginRouter);
// // 上传需要代理到g.16to.com/upload上
// app.use('/api/upload', proxy({
//   target: 'http://g.16to.com',
//   changeOrigin: true,
//   pathRewrite: {
//     '^/api/upload': '/upload', // rewrite path
//   },
// }));
app.use('/api/upload', uploadRouter);
app.use('/api/account', accountRouter);
app.use('/api/article', articleRouter);
app.use('/api/visitor', visitorRouter);
app.use('/api/sysconfig', sysconfigRouter);

// set dist
app.use('/upload', express.static(path.join(__dirname, './upload')));
app.use(express.static(path.join(__dirname, '../dist')));

// set index
app.get('/*', (req, res) => {
  res.sendFile(path.join(__dirname, '../dist', 'index.html'));
});

// bind port
httpServer.listen(PORT, () => {
  console.log(`http start port:${PORT}`);
});
