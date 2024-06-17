function Employee(title) {
    this.title=title;
    this.setTitle=(t0)=>{
        this.title=t0;
    }
    this.getTitle=()=>{return this.title;}
}
Employee.prototype.setTitle=(tit)=> {this.title=tit;}
Employee.prototype.getTitle=()=>{return this.title;}

function Engineer(title, isManager) {
    Employee.call(this,title);
    this.isManager= isManager;
    this.setIsManager=(man) => { this.isManager=man; }
    this.getIsManager=()=> {return this.isManager; }
    
}
Engineer.prototype.setIsManager=(man)=>{
    this.isManager=man;
}
Engineer.prototype.getIsManager=()=>{return this.isManager;}