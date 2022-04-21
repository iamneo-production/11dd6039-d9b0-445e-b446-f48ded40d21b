import React, { Component } from 'react'
import axios from'axios';
const PRODUCT_API_BASE_URL="http://localhost:8080/api/product"
const ProductService ={
     getProduct(){
         return axios.get(PRODUCT_API_BASE_URL);
     }
}
export default new ProductService()