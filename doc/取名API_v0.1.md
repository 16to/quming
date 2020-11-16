# 1.名字模块

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
        //筛选条件支持多个
        "length":[2,3,4],//长度
        "element":["metal","wood"],//metal-金，wood-木，water-水，fire-火,earth-土
        "source":["shijing","chuci"]//shijing-诗经，chuci-楚辞，lunyu-论语，tangshi-唐诗，songci-宋词
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
            //整个名字和单个字的结构区分开
            "id":"名字唯一标识",
            "firstName":"姓",
            "length":2,
            "zodiac":{//生肖
                "type":"类型",//Rat,OX,Tiger,Rabbit,Dragon,Snake,Horse,Sheep,Monkey,Rooster,Dog,Pig
                "name":"名称",//鼠,牛,虎,兔,龙,蛇,马,羊,猴,鸡,狗,猪
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
            },
            "lastName":[
                {
                    "word":"字",
                    "oldword":"繁体",
                    "strokes":10,//笔画
                    "pinyin":"拼音",
                    "explanation":"字典释义",
                    "source":"出处",
                    "celebrity":"名人",
                    "element":{//五行
                        "type":"类型",
                        "name":"名称",
                        "explanation":"解释"
                    }
                },
                {……}
            ] 
        },
        {……}
    ]
}
```

## 2.2收藏

#### 接口路径

POST	/name/actions/collect

#### 请求

```json
{
	"userId":"12345",
	"nameId":"12345"
}
```

#### 响应

```json
{
	"code":0,
    "message":"成功",
    "data":null
}
```

## 2.3查询收藏列表

GET	/name/collections/list

#### 请求

userId=12345

#### 响应

```
{
	"code":0,
    "message":"成功",
    "data":同2.1取名接口返回data数据结构
}
```

