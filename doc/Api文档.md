# Api文档
##  1.Api返回格式（JSON格式）
> * error:错误码，为0时表示成功
> * data:数据信息，error不为0时，此项为错误提示信息

##  2.错误码解释

|错误码|错误提示|
|:------:|:------:|
|501|不存在此分类|
|999|接口维护中|

##  3.接口信息

### 3.1.获取所有游戏分类 /api/RoomApi/game

eg:[http://open.douyucdn.cn/api/RoomApi/game](http://open.douyucdn.cn/api/RoomApi/game)

返回成功时：data里为每一项游戏分类信息
```java
  {
  "error": 0,
  "data": [
    {
      "cate_id": "1",
      "game_name": "英雄联盟",
      "short_name": "LOL",
      "game_url": "http://www.douyu.com/directory/game/LOL",
      "game_src": "https://staticlive.douyucdn.cn/upload/game_cate/c543faae97189c529c37b7741906d5a1.jpg",
      "game_icon": "https://staticlive.douyucdn.cn/upload/game_cate/f0a531a7198cac2ba0747c435644d690.jpg"
    }
  ]
 }
```

|字段名|字段解释|字段样例|
|:------:|:------:|:------:|
|cate_id|游戏分类ID|18|
|game_name|游戏分类名称|英雄联盟|
|short_name|游戏分类别名|lol|
|game_url|游戏分类的网址|http://www.douyu.com/directory/game/LOL|
|game_src|游戏分类的封面图片，大小140x195|https://staticlive.douyucdn.cn/upload/game_cate/c543faae97189c529c37b7741906d5a1.jpg|
|game_icon|游戏分类的小图标图片，大小16x16|https://staticlive.douyucdn.cn/upload/game_cate/f0a531a7198cac2ba0747c435644d690.jpg|

返回错误时：无错误返回

### 3.2.获取直播房间列表信息 /api/RoomApi/live/{分类ID或者分类别名}

http://open.douyucdn.cn/api/RoomApi/live/{分类ID或者分类别名}

Get参数信息

|参数名称|默认值|描述|
|:------:|:------:|:------:|
|offset|0|分页偏移量|
|limit|30|每次获取数量（limit<1或者limit>100时，limit=30）|

eg:获取英雄联盟这个分类下面的房间列表：

(1)[http://open.douyucdn.cn/api/RoomApi/live/lol?offset=0&limit=30](http://open.douyucdn.cn/api/RoomApi/live/lol?offset=0&limit=30)[根据分类简称获取房间列表]

```json
{
  "error": 0,
  "data": [
    {
      "room_id": "436781",
      "room_src": "https://rpic.douyucdn.cn/a1610/11/19/436781_161011193640.jpg",
      "vertical_src": "https://rpic.douyucdn.cn/a1610/11/19/436781_161011193640.jpg",
      "isVertical": 0,
      "cate_id": "1",
      "room_name": "30杀中单双修EZ 一Q一人头",
      "owner_uid": "25932670",
      "nickname": "Lin小北解说",
      "online": 76850,
      "url": "http://www.douyu.com/linxb",
      "game_url": "http://www.douyu.com/directory/game/LOL",
      "game_name": "英雄联盟",
      "avatar": "https://apic.douyucdn.cn/upload/avatar/025/93/26/70_avatar_big.jpg",
      "avatar_mid": "https://apic.douyucdn.cn/upload/avatar/025/93/26/70_avatar_middle.jpg",
      "avatar_small": "https://apic.douyucdn.cn/upload/avatar/025/93/26/70_avatar_small.jpg"
    }
   ]
 }
```

(2)[http://open.douyucdn.cn/api/RoomApi/live/1?offset=0&limit=30](http://open.douyucdn.cn/api/RoomApi/live/1?offset=0&limit=30)[根据分类ID获取房间列表]

(3)[http://open.douyucdn.cn/api/RoomApi/live](http://open.douyucdn.cn/api/RoomApi/live)[获取所有的直播房间列表，后面不跟任何参数]

返回成功时：data里为，每一项房间信息

|字段名|字段解释|字段样例|
|:-----:|:-----:|:------:|
|room_id|房间ID|23|
|room_src|房间图片，大小320x180|https://rpic.douyucdn.cn/a1610/11/19/436781_161011193640.jpg|
|room_name|房间名称|30杀中单双修EZ 一Q一人头|
|owner_uid|房间所属用户的UID|25932670|
|online|在线人数|76850|
|nickname|房间所属用户的账号|Lin小北解说|
|url|房间的网址|http://www.douyu.com/linxb|

返回错误时：错误码501
```json
{
  "error": 501,
  "data": "不存在此分类"
}
```

### 3.3.获取直播房间详情信息 /api/RoomApi/room/{房间ID或者房间别名}

http://open.douyucdn.cn/api/RoomApi/room/{房间ID或者房间别名}

eg:[http://open.douyucdn.cn/api/RoomApi/room/19](http://open.douyucdn.cn/api/RoomApi/room/19)

```json
{
  "error": 0,
  "data": {
    "room_id": "19",
    "room_thumb": "https://rpic.douyucdn.cn/a1610/10/05/19_161010052156.jpg",
    "cate_id": "5",
    "cate_name": "魔兽世界",
    "room_name": "&lt;嗯哼熊&gt;转播美服八强比赛",
    "room_status": "2",
    "owner_name": "yookoN",
    "avatar": "https://apic.douyucdn.cn/upload/avatar/000/00/06/58_avatar_big.jpg?rltime",
    "online": 0,
    "owner_weight": "915.783kg",
    "fans_num": "5091",
    "start_time": "2016-10-10 00:04",
    "gift": [
      {
        "id": "196",
        "name": "火箭",
        "type": "2",
        "pc": 500,
        "gx": 5000,
        "desc": "赠送网站广播并派送出神秘宝箱",
        "intro": "我们的征途是星辰大海",
        "mimg": "http://staticlive.douyucdn.cn/upload/dygift/1606/26f802520cf0e4d8a645259bbc1aadf3.png",
        "himg": "http://staticlive.douyucdn.cn/upload/dygift/1606/39b578b3cb8645b54f9a1001c392a237.gif"
      },
```
返回成功时：data里为每一项房间信息

|字段名|字段解释|字段样例|
|:------:|:------:|:-------:|
|room_id|房间ID|19|
|room_thumb|房间图片，大小320x180|https://rpic.douyucdn.cn/a1610/10/05/19_161010052156.jpg|
|cate_id|房间所属分类ID|19|
|cate_name|房间所属分类名称|魔兽世界|
|room_name|房间名称|&lt;嗯哼熊&gt;转播美服八强比赛|
|room_status|房间开播状态|1（表示开播），2（表示关播）|
|start_time|最近开播时间|2016-10-10 00:04|
|owner_name|房间所属主播昵称|yookoN|
|avatar|房间所属主播头像地址|https://apic.douyucdn.cn/upload/avatar/000/00/06/58_avatar_big.jpg?rltime|
|online|在线人数|0|
|owner_weight|直播间主播体重|915.783kg|
|fans_num|直播间关注数|5091|
|gift|直播间礼物信息数组列表|JSON数组，参数详情请查看下面的礼物参数描述|

gift礼物信息列表中的参数描述详情如下：

|字段名|字段解释|字段样例|
|:------:|:------:|:------:|
|id|礼物ID|196|
|name|礼物名称|火箭|
|type|礼物类型|1（鱼丸礼物）；2（鱼翅礼物）|
|pc|价格|鱼翅礼物（元）/鱼丸礼物（鱼丸）|
|gx|贡献值|5000|
|desc|礼物描述|赠送网站广播并派送出神秘宝箱|
|intro|礼物介绍|我们的征途是星辰大海|
|mimg|礼物图标静态图片地址|http://staticlive.douyucdn.cn/upload/dygift/1606/26f802520cf0e4d8a645259bbc1aadf3.png|
|himg|礼物图标动态图片地址|http://staticlive.douyucdn.cn/upload/dygift/1606/39b578b3cb8645b54f9a1001c392a237.gif|

返回错误时：

|错误码|错误提示信息|
|:------:|:------:|
|101|房间未找到|
|102|房间未激活|
|103|房间获取错误|

