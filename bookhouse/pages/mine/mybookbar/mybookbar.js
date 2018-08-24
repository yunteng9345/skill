// pages/mine/mybookbar/mybookbar.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bookbarlists:""

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getStorage({
      key: 'openid',
      success: function (res) {

        wx.request({
          method: 'GET',
          url: 'http://localhost:8080/kq/json/allBookBarByOpenid',
          header: { //请求头
            "Content-Type": "applciation/json"
          },
          data:{
            "openid":res.data
          },
          success: function (res) {

            //console.log(res.data.booklist)
            that.setData({
              bookbarlists: res.data.bookbarlist
            })

          }
        })

      },
    })

  
  },
  creat(){
    wx.navigateTo({
      url: './createbookbar/createbookbar?',
    })
  },
  ret() {
    wx.navigateBack({

    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this;
    wx.getStorage({
      key: 'openid',
      success: function (res) {

        wx.request({
          method: 'GET',
          url: 'http://localhost:8080/kq/json/allBookBarByOpenid',
          header: { //请求头
            "Content-Type": "applciation/json"
          },
          data:{
            "openid":res.data
          },

          success: function (res) {

            //console.log(res.data.booklist)
            that.setData({
              bookbarlists: res.data.bookbarlist
            })

          }
        })

      },
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})