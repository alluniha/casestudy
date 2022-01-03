import axios from "axios";
import React, { Component } from "react";

class UpdateNotes extends Component {
    constructor(props){
        super(props)
        this.state = {
            task_Id:'',
            notes:'',
        }
        this.changeHandler=this.changeHandler.bind(this);
        this.submitHandler=this.submitHandler.bind(this);
    }
    changeHandler = (event) => {
        this.setState({[event.target.name]:event.target.value})
    }
    submitHandler = (event) => {
        event.preventDefault()
        console.log(this.state)
        axios.get("http://localhost:8080/updatenotes/"+this.state.task_Id+"/"+this.state.notes,this.state)
        .then(response => {
            console.log(response)
        })
        .catch(error => {
            console.log(error)
        })
    }
    render(){
        const {task_Id,notes} = this.state
        return (
            <div>
                <h3>updatenotes</h3>
            <form  onSubmit={this.submitHandler}>
                <div>
                    task_Id:
                    <input type="number" name="task_Id" value={task_Id} onChange={this.changeHandler} placeholder="task_Id" required/>
                </div>
                        
                <div>
                    notes :
                    <input type="text" name="notes" value={notes} onChange={this.changeHandler} placeholder="notes" required/>
                </div>
                 <button type="submit">Submit</button>

            </form>
        </div>
            
        )
    }
}

export default UpdateNotes;