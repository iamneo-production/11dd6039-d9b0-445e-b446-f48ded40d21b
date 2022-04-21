import React, { Component } from 'react'

import {Link} from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'
//import '../css/Details.css'
//import '../css/payment.css'


export class Payment extends Component {
    
    
    render() {    
            return (
                <div>
                    <h2 className="text-center">Yey!! your order has been placed</h2>
                    
                    <Link to="/Product">home </Link>
                    </div>
                
                )
            
        }
}

export default Payment