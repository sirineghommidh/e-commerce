import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {CartItem} from "../../../../common/cart-item";
import {CartServiceService} from "../../../../services/cart-service.service";

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css',
  /*  '../../../../../assets/front/css/bootstrap.min.css',
    '../../../../../javascript/font-awesome/css/font-awesome.min.css',
    '../../../../../css/stylesheet.css',
    '../../../../../css/responsive.css',
    '../../../../../javascript/owl-carousel/owl.carousel.css',
    '../../../../../javascript/owl-carousel/owl.transitions.css',
    '../../../../../javascript/jquery-2.1.1.min.js',
    '../../../../../javascript/bootstrap/js/bootstrap.min.js',
    '../../../../../javascript/template_js/jstree.min.js',
    '../../../../../javascript/template_js/template.js',
    '../../../../../javascript/common.js',
    '../../../../../javascript/global.js',
    '../../../../../javascript/owl-carousel/owl.carousel.min.js'/*/
  ],
  encapsulation: ViewEncapsulation.None
})

export class CartDetailsComponent implements OnInit {

  cartItems : CartItem[]=[];
  totalQuantity:number=0;
  totalPrice : number=0.0;
  constructor(private cartService : CartServiceService) { }

  ngOnInit(): void {
    this.listCartDetails();
  }


  listCartDetails() {
    this.cartItems=this.cartService.cartItems;
    this.cartService.totalPrice.subscribe(data=>this.totalPrice=data);
    this.cartService.totalQuantity.subscribe(data=>this.totalQuantity=data);
    this.cartService.computeCartTotals();
  }

  incrementQuantity(tempCartItem: CartItem) {
    this.cartService.addToCart(tempCartItem);
  }

  decrementQuantity(tempCartItem: CartItem) {
    this.cartService.decrementQuantity(tempCartItem);

  }

  remove(tempCartItem: CartItem) {
    this.cartService.remove(tempCartItem);
  }

}
