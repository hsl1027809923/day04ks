package bean;

import java.util.List;

/*
 *@auther:郝世龙
 *@Date: 2019-12-19
 *@Time:11:20
 *@Description:${DESCRIPTION}
 **/public class CarBean {

    /**
     * result : [{"categoryName":"美妆护肤","shoppingCartList":[{"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/1/1.jpg","price":3499},{"commodityId":13,"commodityName":"贝览得美妆蛋","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/1.jpg","price":44},{"commodityId":14,"commodityName":"美诺MENOW面部刷","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/4/1.jpg","price":47},{"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg","price":6},{"commodityId":5,"commodityName":"双头两用修容笔","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","price":9}]},{"categoryName":"女鞋","shoppingCartList":[{"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","count":3,"pic":"http://172.17.8.100/images/small/commodity/nx/bx/6/1.jpg","price":139},{"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","count":4,"pic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88},{"commodityId":18,"commodityName":"白色经典 秋季新款简约百搭轻便休闲女鞋板鞋小白鞋","count":4,"pic":"http://172.17.8.100/images/small/commodity/nx/bx/1/1.jpg","price":79}]}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "CarBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", result=" + result +
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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * categoryName : 美妆护肤
         * shoppingCartList : [{"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/1/1.jpg","price":3499},{"commodityId":13,"commodityName":"贝览得美妆蛋","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/1.jpg","price":44},{"commodityId":14,"commodityName":"美诺MENOW面部刷","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/4/1.jpg","price":47},{"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg","price":6},{"commodityId":5,"commodityName":"双头两用修容笔","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","price":9}]
         */

        private String categoryName;
        private List<ShoppingCartListBean> shoppingCartList;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "categoryName='" + categoryName + '\'' +
                    ", shoppingCartList=" + shoppingCartList +
                    '}';
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public List<ShoppingCartListBean> getShoppingCartList() {
            return shoppingCartList;
        }

        public void setShoppingCartList(List<ShoppingCartListBean> shoppingCartList) {
            this.shoppingCartList = shoppingCartList;
        }

        public static class ShoppingCartListBean {
            /**
             * commodityId : 3
             * commodityName : Lara style女神的魔盒全套彩妆
             * count : 3
             * pic : http://172.17.8.100/images/small/commodity/mzhf/cz/1/1.jpg
             * price : 3499
             */

            private int commodityId;
            private String commodityName;
            private int count;
            private String pic;
            private int price;
            private boolean isStatu;

            @Override
            public String toString() {
                return "ShoppingCartListBean{" +
                        "commodityId=" + commodityId +
                        ", commodityName='" + commodityName + '\'' +
                        ", count=" + count +
                        ", pic='" + pic + '\'' +
                        ", price=" + price +
                        ", isStatu=" + isStatu +
                        '}';
            }

            public boolean isStatu() {
                return isStatu;
            }

            public void setStatu(boolean statu) {
                isStatu = statu;
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

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }
    }
}
