import axios from "axios";
import React, { Component } from "react";

class UpdateBookmark extends Component {
    constructor(props){
        super(props)
        this.state = {
            taskID:'',
            isBookmarked:'',
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
        axios.get("http://localhost:8080/taskid/"+this.state.taskID+"/"+this.state.isBookmarked,this.state)
        .then(response => {
            console.log(response)
        })
        .catch(error => {
            console.log(error)
        })
    }
    render(){
        const {taskID,isBookmarked} = this.state
        return (
            <div>
                <h3>UpdateBookmark</h3>
            <form  onSubmit={this.submitHandler}>
                <div>
                    taskID:
                    <input type="number" name="taskID" value={taskID} onChange={this.changeHandler} placeholder="task_Id" required/>
                </div>
                        
                <div>
                isBookmarked :
                        <select  name="isBookmarked" value={isBookmarked} onChange={this.changeHandler} >
                                <option value="select">select</option>
                                <option value="true">true</option>
                                <option value="false">false</option>
                            
                        </select>
                </div>
                 <button type="submit">Submit</button>

            </form>
        </div>
            
        )
    }
}

export default UpdateBookmark;