// pages/mine/mybookbar/bookbaraddbook/bookbaraddbook.js
Page({

      /**
       * 页面的初始数据
       */
      data: {
        name: "",
        lists:""
      },

      /**
       * 生命周期函数--监听页面加载
       */
      onLoad: function(options) {
        var that = this;
        that.setData({
          name: options.name
        })
        //console.log(options.name)

        wx.request({
            method: 'GET',
            url: 'http://localhost:8080/kq/json/allBookByBarName',
            header: { //请求头
              "Content-Type": "applciation/json"
            },
            data: {
              "name": options.name
            },
            success: function(res) {

             // console.log(res.data.barbooklist)
              that.setData({
                lists: res.data.barbooklist
              })

            }
          })

          
    


  },
  addbook() {
    // 允许从相机和相册扫码
    wx.scanCode({
      success: (res) => {
        var that = this;
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
              url: '../../addmybook/addmybook?image=' + res.data.image + '&title=' + res.data.title +
                '&author=' + res.data.author[0] + '&bookbar=' + that.data.name,
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