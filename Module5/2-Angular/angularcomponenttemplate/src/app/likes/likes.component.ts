import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-likes',
  templateUrl: './likes.component.html',
  styleUrls: ['./likes.component.css']
})
export class LikesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  likes: number = 0;
  likeThis() {
    this.likes++;
  }

}

