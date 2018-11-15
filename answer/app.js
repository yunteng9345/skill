//app.js
App({
  version: 'v0.0.0', //版本号
  onLaunch: function () {
    //console.log(this.stu.courses[0].course[0].teacherName);
    var _this = this;
    //读取缓存
    try {
      var data = wx.getStorageInfoSync();//同步读取缓存
      if (data && data.keys.length) {
        data.keys.forEach(function (key) {
          var value = wx.getStorageSync(key);
          if (value) {
            _this.cache[key] = value;
          }
        });

        if (_this.cache.version !== _this.version) {//如果当前版本不是最新版本，清除所有缓存，很重要！
          _this.cache = {};
          wx.clearStorage();
        } else {
          _this._user.wx = _this.cache.userinfo.userInfo || {};
          _this.processData(_this.cache.userdata);
        }
      }
    } catch (e) { console.warn('获取缓存失败'); }
  },
  //保存缓存
  saveCache: function (key, value) {
    if (!key || !value) { return; }
    var _this = this;
    _this.cache[key] = value;
    wx.setStorage({
      key: key,
      data: value
    });
  },
  //清除缓存
  removeCache: function (key) {
    if (!key) { return; }
    var _this = this;
    _this.cache[key] = '';
    wx.removeStorage({
      key: key
    });
  },
  //后台切换至前台时
  onShow: function () {

  },
  //判断是否有登录信息，让分享时自动登录
  loginLoad: function (onLoad) {
    var _this = this;
    if (!_this._t) {  //无登录信息
      _this.getUser(function (e) {
        typeof onLoad == "function" && onLoad(e);
      });
    } else {  //有登录信息
      typeof onLoad == "function" && onLoad();
    }
  },
  //getUser函数，在index中调用
  getUser: function (response) {
    var _this = this;
    //wx.showNavigationBarLoading();
    wx.login({
      success: function (res) {
        if (res.code) {
            //发送code与微信用户信息，获取学生数据
            wx.request({
              method: 'GET',
              url: _this._server + '/UserApi/login',
              data: {
                code: res.code,
                encryptedData: res.encryptedData,
                iv: res.iv
              },
              success: function (res) {
                //console.log(res.data.is_bind)
                if (res.data) {
                  var status = false, data = res.data.openid;
                  _this.saveCache("openid",data);//将openid放在缓存中
                  _this._user.openid=data;
              
                  //判断缓存是否有更新
                  if (_this.cache.version !== _this.version ) {
                    _this.saveCache('version', _this.version);
                    _this._user.is_bind =res.data.is_bind;
                    status = true;
                  }
                  if (!_this._user.is_bind) {
                    wx.navigateTo({
                      url: '/pages/more/login'
                    });
                  }
                  //如果缓存有更新，则执行回调函数
                  if (status) {
                    typeof response == "function" && response();
                  }
                } else {
                  //清除缓存
                  if (_this.cache) {
                    _this.cache = {};
                    wx.clearStorage();
                  }
                  typeof response == "function" && response(res.data.message || '加载失败');
                }
              },
              fail: function (res) {
                var status = '';
                // 判断是否有缓存
                if (_this.cache.version === _this.version) {
                  status = '离线缓存模式';
                } else {
                  status = '网络错误';
                }
                _this.g_status = status;
                typeof response == "function" && response(status);
                console.warn(status);
              },
              complete: function () {
                wx.hideNavigationBarLoading();
              }
            });
       //   });
        }
      }
    });
  },
  //完善信息
  showErrorModal: function (content, title) {
    wx.showModal({
      title: title || '加载失败',
      content: content || '未知错误',
      showCancel: false
    });
  },
  showLoadToast: function (title, duration) {
    wx.showToast({
      title: title || '加载中',
      icon: 'loading',
      mask: true,
      duration: duration || 10000
    });
  },
  util: require('./utils/util'),
  key: function (data) {
    return this.util.key(data)
  },
  enCodeBase64: function (data) { return this.util.base64.encode(data) },
  cache: {},
  _server: 'http://localhost:8080',
  _user: {
    //微信数据
    wx: {},
    //学生\老师数据
    we: {}
  },
  stu: {
    "xnxq": "2017-2018-2",
    "classleve": "2015计科",
    "classname": "计算机科学与技术",
    "academy": "信息科学与工程学院",
    "courses": [
      {
        "day": "monday",
        "course": [
          {
            "classNum": "第一大节",
            "className": "单片机",
            "teacherName": "向继文(高级实验师)",
            "classlocal": "新60520"
          },
          {
            "classNum": "第二大节",
            "className": "8:45",
            "teacherName": "数学",
            "classlocal": "张红"
          },
          {
            "classNum": "8:55",
            "className": "9:40",
            "teacherName": "语言E",
            "classlocal": "李晓军"
          },
          {
            "classNum": "9:40",
            "className": "10:10",
            "teacherName": "课堂操",
            "classlocal": "-"
          },
          {
            "classNum": "10:00",
            "className": "10:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          }
        ]
      },
      {
        "day": "tuesday",
        "course": [
          {
            "classNum": "7:40",
            "className": "8:00",
            "teacherName": "早读",
            "classlocal": "-"
          },
          {
            "classNum": "8:00",
            "className": "8:45",
            "teacherName": "数学",
            "classlocal": "张红"
          },
          {
            "classNum": "8:55",
            "className": "9:40",
            "teacherName": "语言E",
            "classlocal": "李晓军"
          },
          {
            "classNum": "9:40",
            "className": "10:10",
            "teacherName": "课堂操",
            "classlocal": "-"
          },
          {
            "classNum": "10:00",
            "className": "10:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "10:45",
            "className": "11:05",
            "teacherName": "眼保健操",
            "classlocal": "-"
          },
          {
            "classNum": "11:05",
            "className": "11:50",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "11:50",
            "className": "14:00",
            "teacherName": "午休",
            "classlocal": "-"
          },
          {
            "classNum": "14:00",
            "className": "14:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "14:55",
            "className": "15:40",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "15:50",
            "className": "16:35",
            "teacherName": "语文",
            "classlocal": "李晓军"
          }
        ]
      },
      {
        "day": "tuesday",
        "course": [
          {
            "classNum": "7:40",
            "className": "8:00",
            "teacherName": "早读",
            "classlocal": "-"
          },
          {
            "classNum": "8:00",
            "className": "8:45",
            "teacherName": "数学",
            "classlocal": "张红"
          },
          {
            "classNum": "8:55",
            "className": "9:40",
            "teacherName": "语言E",
            "classlocal": "李晓军"
          },
          {
            "classNum": "9:40",
            "className": "10:10",
            "teacherName": "课堂操",
            "classlocal": "-"
          },
          {
            "classNum": "10:00",
            "className": "10:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "10:45",
            "className": "11:05",
            "teacherName": "眼保健操",
            "classlocal": "-"
          },
          {
            "classNum": "11:05",
            "className": "11:50",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "11:50",
            "className": "14:00",
            "teacherName": "午休",
            "classlocal": "-"
          },
          {
            "classNum": "14:00",
            "className": "14:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "14:55",
            "className": "15:40",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "15:50",
            "className": "16:35",
            "teacherName": "语文",
            "classlocal": "李晓军"
          }
        ]
      },
      {
        "day": "tuesday",
        "course": [
          {
            "classNum": "7:40",
            "className": "8:00",
            "teacherName": "早读",
            "classlocal": "-"
          },
          {
            "classNum": "8:00",
            "className": "8:45",
            "teacherName": "数学",
            "classlocal": "张红"
          },
          {
            "classNum": "8:55",
            "className": "9:40",
            "teacherName": "语言E",
            "classlocal": "李晓军"
          },
          {
            "classNum": "9:40",
            "className": "10:10",
            "teacherName": "课堂操",
            "classlocal": "-"
          },
          {
            "classNum": "10:00",
            "className": "10:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "10:45",
            "className": "11:05",
            "teacherName": "眼保健操",
            "classlocal": "-"
          },
          {
            "classNum": "11:05",
            "className": "11:50",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "11:50",
            "className": "14:00",
            "teacherName": "午休",
            "classlocal": "-"
          },
          {
            "classNum": "14:00",
            "className": "14:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "14:55",
            "className": "15:40",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "15:50",
            "className": "16:35",
            "teacherName": "语文",
            "classlocal": "李晓军"
          }
        ]
      },
      {
        "day": "tuesday",
        "course": [
          {
            "classNum": "7:40",
            "className": "8:00",
            "teacherName": "早读",
            "classlocal": "-"
          },
          {
            "classNum": "8:00",
            "className": "8:45",
            "teacherName": "数学",
            "classlocal": "张红"
          },
          {
            "classNum": "8:55",
            "className": "9:40",
            "teacherName": "语言E",
            "classlocal": "李晓军"
          },
          {
            "classNum": "9:40",
            "className": "10:10",
            "teacherName": "课堂操",
            "classlocal": "-"
          },
          {
            "classNum": "10:00",
            "className": "10:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "10:45",
            "className": "11:05",
            "teacherName": "眼保健操",
            "classlocal": "-"
          },
          {
            "classNum": "11:05",
            "className": "11:50",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "11:50",
            "className": "14:00",
            "teacherName": "午休",
            "classlocal": "-"
          },
          {
            "classNum": "14:00",
            "className": "14:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "14:55",
            "className": "15:40",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "15:50",
            "className": "16:35",
            "teacherName": "语文",
            "classlocal": "李晓军"
          }
        ]
      },
      {
        "day": "tuesday",
        "course": [
          {
            "classNum": "7:40",
            "className": "8:00",
            "teacherName": "早读",
            "classlocal": "-"
          },
          {
            "classNum": "8:00",
            "className": "8:45",
            "teacherName": "数学",
            "classlocal": "张红"
          },
          {
            "classNum": "8:55",
            "className": "9:40",
            "teacherName": "语言E",
            "classlocal": "李晓军"
          },
          {
            "classNum": "9:40",
            "className": "10:10",
            "teacherName": "课堂操",
            "classlocal": "-"
          },
          {
            "classNum": "10:00",
            "className": "10:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "10:45",
            "className": "11:05",
            "teacherName": "眼保健操",
            "classlocal": "-"
          },
          {
            "classNum": "11:05",
            "className": "11:50",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "11:50",
            "className": "14:00",
            "teacherName": "午休",
            "classlocal": "-"
          },
          {
            "classNum": "14:00",
            "className": "14:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "14:55",
            "className": "15:40",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "15:50",
            "className": "16:35",
            "teacherName": "语文",
            "classlocal": "李晓军"
          }
        ]
      },
      {
        "day": "tuesday",
        "course": [
          {
            "classNum": "7:40",
            "className": "8:00",
            "teacherName": "早读",
            "classlocal": "-"
          },
          {
            "classNum": "8:00",
            "className": "8:45",
            "teacherName": "数学",
            "classlocal": "张红"
          },
          {
            "classNum": "8:55",
            "className": "9:40",
            "teacherName": "语言E",
            "classlocal": "李晓军"
          },
          {
            "classNum": "9:40",
            "className": "10:10",
            "teacherName": "课堂操",
            "classlocal": "-"
          },
          {
            "classNum": "10:00",
            "className": "10:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "10:45",
            "className": "11:05",
            "teacherName": "眼保健操",
            "classlocal": "-"
          },
          {
            "classNum": "11:05",
            "className": "11:50",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "11:50",
            "className": "14:00",
            "teacherName": "午休",
            "classlocal": "-"
          },
          {
            "classNum": "14:00",
            "className": "14:45",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "14:55",
            "className": "15:40",
            "teacherName": "语文",
            "classlocal": "李晓军"
          },
          {
            "classNum": "15:50",
            "className": "16:35",
            "teacherName": "语文",
            "classlocal": "李晓军"
          }
        ]
      }
    ]
  }
  //_time: {} //当前学期周数
}); 