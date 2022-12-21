import {Component, OnInit, ViewEncapsulation} from '@angular/core';

@Component({
  selector: 'app-back',
  templateUrl: './back.component.html',
  styleUrls: ['./back.component.css',
    "../../../assets/back/css/googleapis.css",
    "../../../../node_modules/admin-lte/plugins/fontawesome-free/css/all.min.css",
    "../../../../node_modules/admin-lte/plugins/overlayScrollbars/css/OverlayScrollbars.min.css",
    "../../../../node_modules/admin-lte/dist/css/adminlte.min.css"
  ],
  encapsulation: ViewEncapsulation.None

})

export class BackComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
