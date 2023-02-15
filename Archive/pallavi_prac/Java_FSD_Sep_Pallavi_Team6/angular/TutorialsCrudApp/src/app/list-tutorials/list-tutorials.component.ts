import { Tutorial } from './../tutorial.model';
import { TutorialService } from './../tutorial.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-tutorials',
  templateUrl: './list-tutorials.component.html',
  styleUrls: ['./list-tutorials.component.css']
})
export class ListTutorialsComponent implements OnInit {

  tutorials?: Tutorial[];
  selectedTutorial: Tutorial = {};
  title: string = '';
  currentIndex = -1;
  // description = "Description";
  // status = true;

  constructor(private tutorialService: TutorialService) { }

  ngOnInit(): void {
    this.retrieveTutorials();
  }

  reloadList(): void {
    this.retrieveTutorials();
    this.selectedTutorial = {};
    this.currentIndex = -1;
  }

  retrieveTutorials(): void {
    this.tutorialService.listAllTutorials()
      .subscribe(
        data => {
          this.tutorials = data;
          console.log(data);
        }, error => {
          console.log(error);
        }
      );
  }

  searchByTitle(): void {
    this.selectedTutorial = {};
    this.currentIndex = -1;

    if (this.title == '') {
      this.reloadList();
    } else {
      this.tutorialService.listByTitle(this.title)
      .subscribe(data => {
        this.tutorials = data;
        console.log(data);
      }, error => {
        console.log(error);
      });
    }
  }

  setActiveTutorial(tutorial: Tutorial, index: number): void {
    this.selectedTutorial = tutorial;
    this.currentIndex = index;
  }

}
