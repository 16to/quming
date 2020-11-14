# 1.用户模块

## 1.1获取用户信息

#### 接口路径

GET	/user/info

#### 请求

phone=13812341234

#### 响应

```json
{
	"code":0,
	"message":"成功",
	"data":{
		"userId":"用户ID",
        "name":"用户名，可以为空",
        "phone":"手机号"
	}
}
```



## 1.2登录

#### 接口路径

POST	/user/actions/login

#### 请求

phone=13812341234

#### 响应

```json
{
	"code":0,
    "message":"成功",
    "data":null
}
```

## 1.3发送短信验证码

#### 接口路径

POST	/user/actions/sendVerify

#### 请求

phone=13812341234

#### 响应

```json
{
	"code":0,
    "message":"成功",
    "data":null
}
```

## 

# 2.名字模块

## 2.1取名

#### 接口路径

POST	/name/actions/generate

#### 请求

```json
{
	"firstName":"姓",//必传
    "birth":"出生时间",//必传
    "sex":0,//必传，0-女，1-男
    "selectParam":{
        "length":2,//长度
        "element":"五行",//metal-金，wood-木，water-水，fire-huo,earth-土
        "source":"出处"//shijing-诗经，chuci-楚辞，lunyu-论语，tangshi-唐诗，songci-宋词
    }
}
```



#### 响应

```json
{
	"code":0,
	"message":"成功",
    "data":[
        {
            "id":"名字唯一标识",
            "firstName":"姓",
            "lastName":"名",
            "length":2,
            "oldword":"繁体",
            "strokes":10,//笔画
            "pinyin":"拼音",
            "explanation":"字典释义",
            "source":"出处",
            "celebrity":"名人",
            "zodiac":{//生肖
                "type":"类型",//Rat,OX,Tiger,Rabbit,Dragon,Snake,Horse,Sheep,Monkey,Rooster,Dog,Pig
                "name":"名称",//鼠,牛,虎,兔,龙,蛇,马,羊,猴,鸡,狗,猪
                "explanation":"解释"
            },
            "element":{//五行
                "type":"类型",
                "name":"名称",
                "explanation":"解释"
            },
            "constellation":{//星座
                "type":"类型",//Aries,Gemini,Leo,Libra,Sagittarius,Aquarius,Taurus,Cancer,Virgo,Scorpio,Capricorn,Pisces
                "name":"名称",//白羊座,双子座,狮子座,天秤座,射手座,水瓶座,金牛座,巨蟹座,处女座,天蝎座,摩羯座,双鱼座
                "explanation":"解释"
            },
            "same":{//同名
                "male":10,//男性
                "female":12,//女性
            }
        }
    ]
}
```

## 2.2收藏

#### 接口路径

POST	/name/actions/collect

#### 请求

userId=12345&nameId=12345

#### 响应

```json
{
	"code":0,
    "message":"成功",
    "data":null
}
```

