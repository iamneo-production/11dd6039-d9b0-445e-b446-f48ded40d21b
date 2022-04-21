import React, { Component } from 'react'
import {DataContext} from '../Context'
import {Link} from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'
import '../css/Details.css'
import '../css/Cart.css'


export class myorders extends Component { 
    static contextType = DataContext;

    componentDidMount(){
        this.context.getTotal();
    }
    
    render() {
    
            
        
        const {cart,total} = this.context;
        if(cart.length === 0){
            
                
            
            return <h2 style={{textAlign:"center"}}>No Products</h2>
        }else{
            return (
                <div>
                    <h2 className="text-center">MY-ORDERS</h2>
                    <div className="row">
                        <table className ="table table=striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                            {
                        cart.map(item =>(
                            <tr key={item._id}>
                                <td>{<img src= {`./${item.Product_img}`} alt=""/>}</td>
                                
                                <td>{item.Product_description}</td>
                                <span>{item.count}</span>
                                <td>${item.Product_price * item.count}</td>
                                
                                
                               
                                
                               
                            </tr>
                        ))
                    }

                            </tbody>
                            </table>
                    
                    <div className="total">
                    <h3>Total: ${total}</h3>
                    <Link to="/payment">place-order</Link>
                        
                    </div>
                </div>
                </div>
                )
            }
        }
}

export default myorders
