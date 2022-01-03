import axios from "axios";

import React, { Component } from "react";



class Addtask extends Component {

    constructor(props){

        super(props)

        this.state = {

            taskID:'',

            ownerID:'',

            creator:'',

            name:'',

            description:'',

            status:'',

            priority:'',

            isBookmarked:'',

            createdOn:'',

            statusChangedOn:''

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

        axios.post('http://localhost:8080/createTask',this.state)

        .then(response => {

            console.log(response)

        })

        .catch(error => {

            console.log(error)

        })

    }



    render(){

        const {taskID,ownerID,creatorID,name,description,status,priority,notes,isBookmarked,createdOn,statusChangedOn} = this.state

        return (
            <div>
                <div>
                <h2>Add TASK</h2>
                </div>
                
                <form onSubmit={this.submitHandler}>
                    <div>
                    task_Id:
                        <input type="number" name="taskID" value={taskID} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <div>
                    owner_Id:
                        <input type="number" name="ownerID" value={ownerID} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <div>
                    creator_Id:
                        <input type="number" name="creatorID" value={creatorID} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <div>
                    name:
                        <input type="string" name="name" value={name} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <div>
                    description:
                        <input type="string" name="description" value={description} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <div>
                    status:
                        <select  name="status" value={status} onChange={this.changeHandler}>
                        <option value="Close">Close</option>
                        <option value="InProgress">InProgress</option>
                        <option value="Cancelled">Cancelled</option>
                        <option value="OnHold">OnHold</option>
                        </select>

                    </div>
                    <br></br>
                    <div>
                    priority:
                        <select name="priority" value={priority} onChange={this.changeHandler}>
                        <option value="High">High</option>
                        <option value="Medium">Medium</option>
                        <option value="Low">Low</option>
                        </select>
                    </div>
                    <br></br>
                    <div>
                    notes:
                        <input type="string" name="notes" value={notes} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <div>
                    isBookmarked:
                        <select name="isBookmarked" value={isBookmarked} onChange={this.changeHandler}>
                        <option value="True">True</option>
                        <option value="False">False</option>
                        </select>
                    </div>
                    <br></br>
                    <div>
                    created_On:
                        <input type="date" name="createdOn" value={createdOn} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <div>
                    statusChanged_On:
                        <input type="datetime-local" name="statusChangedOn" value={statusChangedOn} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <button type="submit">submit</button>
                    
                </form>
            </div>
        )
    }
    
}

export default Addtask;