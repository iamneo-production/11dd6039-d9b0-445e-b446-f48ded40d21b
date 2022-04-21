import React, { Component } from 'react'
import {DataContext} from '../Context'
import {Link} from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'
import '../css/Details.css'
import '../css/Cart.css'


export class Cart extends Component {
    static contextType = DataContext;

    componentDidMount(){
        this.context.getTotal();
    }
    
    render() {
    
            
        
        const {cart,increase,reduction,removeProduct,total} = this.context;
        if(cart.length === 0){
            
                
            
            return <h2 style={{textAlign:"center"}}>No Products</h2>
        }else{
            return (
                <div>
                    <h2 className="text-center">CART</h2>
                    <div className="row">
                        <table className ="table table=striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Title</th>
                                    <th>Description</th>
                                    <th>Price</th>
                                    <th>actions</th>
                                </tr>
                            </thead>
                            <tbody>
                            {
                        cart.map(item =>(
                            <tr key={item._id}>
                                <td>{<img src= {`./${item.Product_img}`} alt=""/>}</td>
                                <td>{item.Product_name}</td>
                                <td>{item.Product_description}</td>
                                <td>${item.Product_price * item.count}</td>
                                <div className="box">   
                                   <div className="amount">
                                        <button className="count" onClick={() => reduction(item._id)}> - </button>
                                        <span>{item.count}</span>
                                        <button className="count" onClick={() => increase(item._id)}> + </button>
                                        <div className="delete" onClick={() => removeProduct(item._id)}>X</div>
                                    </div>
                                    <div className="delete" onClick={() => removeProduct(item._id)}>X</div>
                                </div>
                               
                                
                               
                            </tr>
                        ))
                    }

                            </tbody>
                            </table>
                    
                    <div className="total">
                    <h3>Total: ${total}</h3>
                    <Link to="/payment">Payment</Link>
                        
                    </div>
                </div>
                </div>
                )
            }
        }
}

export default Cart
