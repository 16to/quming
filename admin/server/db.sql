/*
* quming database
*/

DROP TABLE IF EXISTS `qm_table`;
CREATE TABLE `qm_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` char(200) NOT NULL DEFAULT '',
  `content` longtext,
  `addtime` bigint(20) DEFAULT '0',
  `updatetime` bigint(20) DEFAULT '0',
  `imagename` char(200) DEFAULT '',
  `creator` char(20) DEFAULT '',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `qm_account`;
CREATE TABLE `qm_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(200) NOT NULL DEFAULT '',
  `password` char(200) NOT NULL DEFAULT '',
  `addtime` bigint(20) DEFAULT '0',
  `logincount` int(11) DEFAULT '0',
  `lasttime` bigint(20) DEFAULT '0',
  `state` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;
INSERT INTO `qm_account` VALUES ('1', 'admin', 'admin', '0', '0', '0', '1');

DROP TABLE IF EXISTS `qm_loginlog`;
CREATE TABLE `qm_loginlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(200) NOT NULL DEFAULT '',
  `logintime` bigint(20) DEFAULT '0',
  `loginip` char(20) DEFAULT '127.0.0.1',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `qm_article`;
CREATE TABLE `qm_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(20) NOT NULL,
  `type` int(5) DEFAULT '0',
  `tag` int(5) DEFAULT '0',
  `click` int(11) DEFAULT '0',
  `sort` int(11) DEFAULT '0',
  `content` longtext,
  `updatetime` int(10) NOT NULL DEFAULT '0',
  `addtime` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `type` (`type`),
  KEY `tag` (`tag`),
  KEY `sort` (`sort`),
  KEY `click` (`click`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `qm_visitor`;
CREATE TABLE `qm_visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` char(200) NOT NULL DEFAULT '',
  `visitortime` bigint(20) DEFAULT 0,
  `visitorip` char(20) DEFAULT '127.0.0.1',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `qm_banner`;
CREATE TABLE `qm_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `sort` int(11) DEFAULT '0',
  `img` varchar(255) NOT NULL DEFAULT '',
  `addtime` int(10) NOT NULL DEFAULT '0',
  `updatetime` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `sort` (`sort`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `qm_postor`;
CREATE TABLE `qm_postor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` char(200) NOT NULL DEFAULT '',
  `postortime` bigint(20) DEFAULT '0',
  `postorbirthday` char(20) DEFAULT '',
  `postorsex` char(20) DEFAULT '',
  `postorfname` char(20) DEFAULT '',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;