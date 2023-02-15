export class Tutorial {
  tutorialId?: number;
  title?: string;
  description?: string;
  published?: boolean;

  constructor(id: number, name: string, desc: string, pub: boolean) {
    this.tutorialId = id;
    this.title = name;
    this.description = desc;
    this.published = pub;
  }
}
