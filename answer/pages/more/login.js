//login.js
//获取应用实例
var app = getApp();
Page({
  data: {
    remind: '加载中',
    help_status: false,
    userid_focus: false,
    passwd_focus: false,
    userid: '',
    passwd: '',
    angle: 0
  },
  onReady: function () {
    var _this = this;
    setTimeout(function () {
      _this.setData({
        remind: ''
      });
    }, 1000);
    wx.onAccelerometerChange(function (res) {
      var angle = -(res.x * 30).toFixed(1);
      if (angle > 14) { angle = 14; }
      else if (angle < -14) { angle = -14; }
      if (_this.data.angle !== angle) {
        _this.setData({
          angle: angle
        });
      }
    });
  },
  bind: function () {
    var _this = this;
    // if (app.g_status) {
    //   app.showErrorModal(app.g_status, '绑定失败');
    //   return;
    // }
    if (!_this.data.userid || !_this.data.passwd) {
      app.showErrorModal('账号及密码不能为空', '提醒');
      return false;
    }
    // if (!app._user.openid) {
    //   app.showErrorModal('未能成功登录', '错误');
    //   return false;
    // }
    app.showLoadToast('绑定中');
    wx.request({
      method: 'GET',
      url: app._server + '/UserApi/bind',
      data: {
        openid: app.cache.openid,
        uid: _this.data.userid,
        pd: _this.data.passwd
      },
      success: function (res) {
        console.log(res.data)
        if (res.data.status=='200') {//服务器发送状态码
          app.showLoadToast('请稍候');
          //清除缓存
          app.cache = {};
          wx.clearStorage();
          app.getUser(function () {
            wx.showToast({
              title: '绑定成功',
              icon: 'success',
              duration: 1500
            })
          wx.navigateBack();
          })
        }
        else {
          wx.hideToast();
          app.showErrorModal(res.data.message, '绑定失败');
        }
      },
      fail: function (res) {
        wx.hideToast();
        app.showErrorModal(res.errMsg, '绑定失败');
      }
    });
  },
  useridInput: function (e) {
    this.setData({
      userid: e.detail.value
    });
    if (e.detail.value.length >= 11) {
      wx.hideKeyboard();
    }
  },
  passwdInput: function (e) {
    this.setData({
      passwd: e.detail.value
    });
  },
  inputFocus: function (e) {
    if (e.target.id == 'userid') {
      this.setData({
        'userid_focus': true
      });
    } else if (e.target.id == 'passwd') {
      this.setData({
        'passwd_focus': true
      });
    }
  },
  inputBlur: function (e) {
    if (e.target.id == 'userid') {
      this.setData({
        'userid_focus': false
      });
    } else if (e.target.id == 'passwd') {
      this.setData({
        'passwd_focus': false
      });
    }
  },
  tapHelp: function (e) {
    if (e.target.id == 'help') {
      this.hideHelp();
    }
  },
  showHelp: function (e) {
    this.setData({
      'help_status': true
    });
  },
  hideHelp: function (e) {
    this.setData({
      'help_status': false
    });
  }
});