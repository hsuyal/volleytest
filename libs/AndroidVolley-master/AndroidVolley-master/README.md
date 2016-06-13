AndroidVolley
=============

## 背景

[Volley](https://android.googlesource.com/platform/frameworks/volley)是Google I/O 2013推出的网络通信库，在volley推出之前我们一般会选择比较成熟的第三方网络通信库，如：

* [android-async-http](http://loopj.com/android-async-http/)

* [retrofit](http://square.github.io/retrofit/)

* [okhttp](http://square.github.io/okhttp/)

他们各有优劣，之前个人则比较喜欢用android-async-http, 如今Google推出了官方的针对Android平台上的网络通信库，能使网络通信更快，更简单，更健壮，Volley在提供了高性能网络通讯功能的同时，对网络图片加载也提供了良好的支持，完全可以满足简单REST客户端的需求, 我们没有理由不跟上时代的潮流。

## 使用Volley

下载Volley源码并build jar包。

    $ git clone https://android.googlesource.com/platform/frameworks/volley
    $ cd volley
    $ android update project -p
    $ ant jar

然后把生成的jar包引用到我们的项目中，extras目录下则包含了目前最新的volley源码。


## 说明

此Demo主要介绍了日常网络开发常用的基本功能，但volley的扩展性很强，可以根据需要定制你自己的网络请求。

![AndroidVolley](https://raw2.github.com/stormzhang/AndroidVolley/master/art/snap.jpg)

## 关于我

[见这里](http://stormzhang.github.io/about.html)

License
============

    Copyright 2014 Storm Zhang

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/stormzhang/androidvolley/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

