// pages/mine/mybookbar/creatbookbar/createbookbar.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },
  formSubmit: function (e) {
    var that = this;
    //console.log('form发生了submit事件，携带数据为：', e.detail.value.image)
    wx.getStorage({
      key: 'openid',
      success: function (res) {
        //var openid = res.data
        //console.log(this.image)
        wx.request({
          method: 'GET',
          url: 'http://localhost:8080/kq/json/addBookBar',
          header: { //请求头
            "Content-Type": "applciation/json"
          },
          data: {
            "name": e.detail.value.name,
            "addr": e.detail.value.addr,
            "miaoshu": e.detail.value.miaoshu,
            "openid":res.data,
          },

          success: function (res) {
            console.log("用户信息到服务器success")
            wx.navigateBack({
              
            })
          }
        })

      },
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