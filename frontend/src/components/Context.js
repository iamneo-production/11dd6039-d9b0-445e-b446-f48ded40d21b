import 
React, { Component } from 'react'

export const DataContext = React.createContext();

export class DataProvider extends Component {

    state = {
        products: [
            {
                "_id": "1",
                "Product_name": "gemstone1",
                "Product_img": "images/img1.jpeg",
                "Product_description": "INDIAN DIAMOND JEWELLERY",
                "content": "pearls and gems",
                "Product_price": 40000,
            
                "count": 1
            },
            {
                "_id": "2",
                "Product_name": "gemstone2",
                "Product_img": "images/img2.jpg",
                "Product_description": "CHOKER NECKLACE",
                "content": "Exclusive gold plated wedding jewellery kundan chocker necklace ",
                "Product_price": 19000,
        
                "count": 1
            },
            {
                "_id": "3",
                "Product_name": "gemstone3",
                "Product_img": "images/img3.jpg",
                "Product_description": "DIAMOND JEWELLERY",
                "content": "Exclusive platinum plated wedding jewellery  chocker necklace",
                "Product_price": 50000,
            
                "count": 1
            },
            {
                "_id": "4",
                "Product_name": "gemstone4",
                "Product_img": "images/img4.jpg",
                "Product_description": "paltinum choker",
                "content": "Exclusive platinum plated wedding jewellery  chocker necklace",
                "Product_price": 15000,
                
                "count": 1
            },
            {
                "_id": "5",
                "Product_name": "gemstone5",
                "Product_img": "images/img5.jpg",
                "Product_description": "BANGLES",
                "content": "Exclusive platinum plated bangles  ",
                "Product_price": 10000,
                
                "count": 1
            },
            {
                "_id": "6",
                "Product_name": "gemstone6",
                "Product_img": "images/img6.jpg",
                "Product_description": "CHOKER",
                "content": "Exclusive platinum plated wedding jewellery  chocker necklace",
                "Product_price": 17000,
                
                "count": 1
            }
        ],
        cart: [],
        total: 0
        
    };

    addCart = (id) =>{
        const {products, cart} = this.state;
        const check = cart.every(item =>{
            return item._id !== id
        })
        if(check){
            const data = products.filter(product =>{
                return product._id === id
            })
            this.setState({cart: [...cart,...data]})
        }else{
            alert("The product has been added to cart.")
        }
    };

    reduction = id =>{
        const { cart } = this.state;
        cart.forEach(item =>{
            if(item._id === id){
                item.count === 1 ? item.count = 1 : item.count -=1;
            }
        })
        this.setState({cart: cart});
        this.getTotal();
    };

    increase = id =>{
        const { cart } = this.state;
        cart.forEach(item =>{
            if(item._id === id){
                item.count += 1;
            }
        })
        this.setState({cart: cart});
        this.getTotal();
    };

    removeProduct = id =>{
        if(window.confirm("Do you want to delete this product?")){
            const {cart} = this.state;
            cart.forEach((item, index) =>{
                if(item._id === id){
                    cart.splice(index, 1)
                }
            })
            this.setState({cart: cart});
            this.getTotal();
        }
       
    };

    getTotal = ()=>{
        const{cart} = this.state;
        const res = cart.reduce((prev, item) => {
            return prev + (item.Product_price * item.count);
        },0)
        this.setState({total: res})
    };
    
    componentDidUpdate(){
        localStorage.setItem('dataCart', JSON.stringify(this.state.cart))
        localStorage.setItem('dataTotal', JSON.stringify(this.state.total))
    };

    componentDidMount(){
        const dataCart = JSON.parse(localStorage.getItem('dataCart'));
        if(dataCart !== null){
            this.setState({cart: dataCart});
        }
        const dataTotal = JSON.parse(localStorage.getItem('dataTotal'));
        if(dataTotal !== null){
            this.setState({total: dataTotal});
        }
    }
   

    render() {
        const {products, cart,total} = this.state;
        const {addCart,reduction,increase,removeProduct,getTotal} = this;
        return (
            <DataContext.Provider 
            value={{products, addCart, cart, reduction,increase,removeProduct,total,getTotal}}>
                {this.props.children}
            </DataContext.Provider>
        )
    }
}


