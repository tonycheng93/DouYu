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
