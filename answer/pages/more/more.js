//more.js
//获取应用实例
var app = getApp();
Page({
  data: {
    //ava:'',
    user: {}
  },
  onShow: function(){
    this.getData();
  },

  bindGetUserInfo:function(e){
    var _this=this;
    console.log(e.detail.userInfo.avatarUrl)
    if (e.detail.userInfo) {
      _this.setData({
        ava:e.detail.userInfo.avatarUrl
      })
    } else {
      //用户按了拒绝按钮
    }
  }
  ,
  getData: function(){
    var _this = this;
    var days = ['一','二','三','四','五','六','日'];
    _this.setData({
       'user': app._user,
      'time': {
        'term': app._time.term,
        'week': app._time.week,
        'day': days[app._time.day - 1]
      },
      'is_bind': !!app._user.is_bind
      //'is_bind': app._user.is_bind

    });
  }
});