import {Component, OnInit, ViewEncapsulation} from '@angular/core';

@Component({
  selector: 'app-front',
  templateUrl: './front.component.html',
  styleUrls: [
    './front.component.css',
    '../../../assets/front/css/bootstrap.min.css',
    '../../../assets/front/javascript/font-awesome/css/font-awesome.min.css',
    '../../../assets/front/css/font/amiro.css',
    '../../../assets/front/css/font/roboto+slab.css',
    '../../../assets/front/css/stylesheet.css',
    '../../../assets/front/css/responsive.css',
    '../../../assets/front/javascript/owl-carousel/owl.carousel.css',
    '../../../assets/front/javascript/owl-carousel/owl.transitions.css',

  ],
  encapsulation: ViewEncapsulation.None
})
export class FrontComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
