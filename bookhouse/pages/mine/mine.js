// pages/mine/mine.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //用户个人信息
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    num:""

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function() {
    //地址授权
    // wx.openSetting({
    //   success: (res) => {
        
    //      res.authSetting = {
    //         "scope.userInfo": true,
    //         "scope.userLocation": true
    //       }
    //     openSetting:fail 此接口已废弃，请使用 OpenSetting 组件
    //   }
    // })

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
      
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    //console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
    //将用户信息存到服务器
    wx.getStorage({
      key: 'openid',
      success: function (res) {
        //var openid = res.data
        //console.log(res.data)
        wx.request({
          method: 'GET',
          url: 'http://localhost:8080/kq/json/addUser',
          header: { //请求头
            "Content-Type": "applciation/json"
          },
          data: {
            "openid": res.data,
            "uname": e.detail.userInfo.nickName,
            "usex": e.detail.userInfo.gender,
            "uicon": e.detail.userInfo.avatarUrl
          },

          success: function (res) {
            console.log("用户信息到服务器success")
            
          }
        })

      },
    })


  },
  addbook() {
    // 允许从相机和相册扫码
    wx.scanCode({
      success: (res) => {
        //console.log(res.result)
         wx.setStorage({
           key: 'isbn',
           data: res.result,
         })
        //通过豆瓣api请求图书信息
        wx.request({
          method: 'GET',
          url: 'http://localhost:8080/kq/json/book',
          header: { //请求头
            "Content-Type": "applciation/json"
          },
          data: {
            "isbn": res.result
          },

          success: function(res) {
            wx.navigateTo({
              url: './addmybook/addmybook?image=' + res.data.image + '&title=' + res.data.title +
                '&author=' + res.data.author[0] +'&bookbar='+"无书吧",
            })
            console.log(res.data.image)
            console.log(res.data.title)
            console.log(res.data.author[0])
          }
        })
      }
    })

  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    var that=this
    wx.getStorage({
      key: 'openid',
      success: function(res) {
        wx.request({
          method: 'GET',
          url: 'http://localhost:8080/kq/json/selectAppoint',
          header: { //请求头
            "Content-Type": "applciation/json"
          },
          data: {
            "openid2": res.data
          },
          success: function (res) {

            //console.log(res.data.appointlist.length)
              that.setData({
                num: res.data.appointlist.length
              })

          }
        })

      },
    })
    

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})