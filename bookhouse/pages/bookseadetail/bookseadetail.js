// pages/bookseadetail/bookseadetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    image: "",
    title: "",
    author: "",
    bookopenid: "",
    hiddenmodalput: true,
    content: "",
    isbn:"",
    commentlist:""

  },
  contentInput: function(e) {
    var that = this
    that.setData({
      content: e.detail.value
    })
  },
  /*
  预约书籍
  */
  appoint: function() {
    var that = this
    this.setData({
      hiddenmodalput: !this.data.hiddenmodalput
    })

  },
  //取消按钮
  cancel: function() {
    this.setData({
      hiddenmodalput: true
    });
    //console.log("cancel")
  },
  //确认
  confirm: function() {
    var that = this
    //var content = e.detail.value
    // console.log(that.data.content)
    this.setData({
      hiddenmodalput: true
    })
    wx.getStorage({
      key: 'openid',
      success: function(res) {
        wx.request({
          method: 'GET',
          url: 'http://localhost:8080/kq/json/appoint',
          header: { 
            "Content-Type": "applciation/json"
          },
          data: {
            "openid1": res.data,
            "openid2": that.data.bookopenid,
            "content": that.data.content,
            "isbn":that.data.isbn,
            "flag":"1"

          },
          success: function(res) {
            wx.showModal({
              title: '预约成功',
              content: '请到我的私信中查看具体预约信息！',
              success: function (res) {
                if (res.confirm) {
                  console.log('用户点击确定')
                } else if (res.cancel) {
                  console.log('用户点击取消')
                }
              }
            }) 
            //console.log(res.data.booklist)
            // that.setData({
            //   booklists: res.data.booklist
            // })

          }
        })

      },
    })

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
      bookopenid: options.bookopenid,
      isbn:options.isbn
    })


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
  transpond(e) {

    var image = e.currentTarget.dataset.bookpic
    var that=this
    wx.navigateTo({
      url: './transpond/transpond?image=' + image+"&title="+that.data.title,
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