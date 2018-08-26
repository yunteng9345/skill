// pages/bookseadetail/bookseadetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    image: "",
    title: "",
    author: "",
    hiddenmodalput: true,
    isbn: "",
    comment:"",
    commentlist: ""

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    that.setData({
      image: options.image,
      title: options.title,
      author: options.author,
      isbn: options.isbn
    })

    this.temp()


  },
  txtinput: function(e) {
    var that = this
    that.setData({
      comment: e.detail.value
    })
  },
  jiaojie() {
    var that = this
    this.setData({
      hiddenmodalput: !this.data.hiddenmodalput
    })
    console.log("jiaojie")

  },
  //取消按钮
  cancel: function() {
    this.setData({
      hiddenmodalput: true
    });
    // console.log("cancel")
  },
  //确认
  confirm: function() {
    // console.log("确定")
  },
  transpond(e) {
    var image = e.currentTarget.dataset.bookpic
    wx.navigateTo({
      url: './transpond/transpond?image=' + image,
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
  temp(){
    var that = this
    wx.request({
      method: 'GET',
      url: 'http://localhost:8080/kq/json/showAllComment',
      header: { //请求头
        "Content-Type": "applciation/json"
      },
      data: {
        isbn: that.data.isbn
      },
      success: function (res) {
        that.setData({
          commentlist: res.data.allComment
        })

      }
    })

  },
  onShow: function() {
    //this.onLoad()
  },

  submit() {
    var that = this
    wx.getStorage({
      key: 'openid',
      success: function(res) {
        console.log(that.data.comment)
        wx.request({
          method: 'GET',
          url: 'http://localhost:8080/kq/json/comment',
          header: { //请求头
            "Content-Type": "applciation/json"
          },
          data:{
            "openid":res.data,
            "isbn":that.data.isbn,
            "comment":that.data.comment
          },

          success: function (res) {
          that.temp()
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