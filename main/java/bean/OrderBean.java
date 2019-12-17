package bean;

import java.util.List;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:11:00
 *@Description:${DESCRIPTION}
 **/public class OrderBean {

    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","commodityPic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/2.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/3.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/4.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/5.jpg","commodityPrice":88,"orderDetailId":22132},{"commentStatus":1,"commodityCount":1,"commodityId":12,"commodityName":"Lara style美妆BB蛋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/4.jpg","commodityPrice":22,"orderDetailId":22133}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121609005096311311","orderStatus":3,"orderTime":1576458051000,"payAmount":110,"payMethod":1,"userId":11311},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":7,"commodityName":"蓝色之恋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/5/5.jpg,","commodityPrice":29,"orderDetailId":22128},{"commentStatus":1,"commodityCount":1,"commodityId":13,"commodityName":"贝览得美妆蛋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/5.jpg","commodityPrice":44,"orderDetailId":22129}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121609000643811311","orderStatus":3,"orderTime":1576458006000,"payAmount":73,"payMethod":1,"userId":11311},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/1/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/1/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/1/3.jpg","commodityPrice":3499,"orderDetailId":22124},{"commentStatus":1,"commodityCount":1,"commodityId":5,"commodityName":"双头两用修容笔","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/5.jpg,","commodityPrice":39,"orderDetailId":22125}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121608590727211311","orderStatus":1,"orderTime":1576457947000,"payAmount":3538,"payMethod":1,"userId":11311},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":17,"commodityName":"化妆镜","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/5.jpg","commodityPrice":31,"orderDetailId":21679},{"commentStatus":1,"commodityCount":1,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/5.jpg,","commodityPrice":39,"orderDetailId":21680}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121211515384511311","orderStatus":3,"orderTime":1576122714000,"payAmount":70,"payMethod":1,"userId":11311},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":29,"commodityName":"秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲","commodityPic":"http://172.17.8.100/images/small/commodity/nx/ddx/5/1.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/5/2.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/5/3.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/5/4.jpg,http://172.17.8.100/images/small/commodity/nx/ddx/5/5.jpg","commodityPrice":278,"orderDetailId":21677},{"commentStatus":1,"commodityCount":1,"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","commodityPic":"http://172.17.8.100/images/small/commodity/nx/bx/6/1.jpg,http://172.17.8.100/images/small/commodity/nx/bx/6/2.jpg,http://172.17.8.100/images/small/commodity/nx/bx/6/3.jpg,http://172.17.8.100/images/small/commodity/nx/bx/6/4.jpg,http://172.17.8.100/images/small/commodity/nx/bx/6/5.jpg","commodityPrice":139,"orderDetailId":21678}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121211493875311311","orderStatus":2,"orderTime":1576122579000,"payAmount":417,"payMethod":1,"userId":11311}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

    @Override
    public String toString() {
        return "OrderBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", orderList=" + orderList +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":1,"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","commodityPic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/2.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/3.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/4.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/5.jpg","commodityPrice":88,"orderDetailId":22132},{"commentStatus":1,"commodityCount":1,"commodityId":12,"commodityName":"Lara style美妆BB蛋","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/2/4.jpg","commodityPrice":22,"orderDetailId":22133}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2019121609005096311311
         * orderStatus : 3
         * orderTime : 1576458051000
         * payAmount : 110
         * payMethod : 1
         * userId : 11311
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        @Override
        public String toString() {
            return "OrderListBean{" +
                    "expressCompName='" + expressCompName + '\'' +
                    ", expressSn='" + expressSn + '\'' +
                    ", orderId='" + orderId + '\'' +
                    ", orderStatus=" + orderStatus +
                    ", orderTime=" + orderTime +
                    ", payAmount=" + payAmount +
                    ", payMethod=" + payMethod +
                    ", userId=" + userId +
                    ", detailList=" + detailList +
                    '}';
        }

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 1
             * commodityId : 32
             * commodityName : 唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋
             * commodityPic : http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/2.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/3.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/4.jpg,http://172.17.8.100/images/small/commodity/nx/fbx/1/5.jpg
             * commodityPrice : 88
             * orderDetailId : 22132
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            @Override
            public String toString() {
                return "DetailListBean{" +
                        "commentStatus=" + commentStatus +
                        ", commodityCount=" + commodityCount +
                        ", commodityId=" + commodityId +
                        ", commodityName='" + commodityName + '\'' +
                        ", commodityPic='" + commodityPic + '\'' +
                        ", commodityPrice=" + commodityPrice +
                        ", orderDetailId=" + orderDetailId +
                        '}';
            }

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
