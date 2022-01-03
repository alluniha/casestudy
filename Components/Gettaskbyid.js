import axios from "axios";

import React, { Component } from "react";



class Gettaskbyid extends Component {

    constructor(props){

        super(props)

        this.state = {

            tasks:[],

            taskID:''



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

        axios.get("http://localhost:8080/taskid/"+this.state.taskID)

        .then(response => {

            this.setState({tasks:response.data})

            console.log(response.data)

        })

    }



    render(){

        const {taskID, tasks} = this.state

        return (
          
            <div>
                <h3>GetTaskBYid</h3>
                  <form  onSubmit={this.submitHandler}>
                <div>
                taskID:
                    <input type="number" name="taskID" value={taskID} onChange={this.changeHandler} placeholder="taskID" required/>
                </div>
                 <button className='button' type="submit">Submit</button>

            </form>
                
                <table style={{"textAlign":"right"}}>
                    <thead>
                        <tr>
                            <th>TaskName</th>
                            <th>TaskID</th>
                            <th>priority</th>
                            <th>status</th>
                            <th>OwnerId</th>
                            <th>isBookmarked</th>
                            <th> Created_On</th>
                    <th>Status_Changed_On</th>
                            </tr>
                    </thead>
                    <tbody>
                    {

tasks.map(task =>

<tr>

  <td>{task.taskID}</td>

  <td>{task.ownerID}</td>

  <td>{task.creatorID}</td>

  <td>{task.name}</td>

  <td>{task.description}</td>

  <td>{task.status}</td>

  <td>{task.priority}</td>

  <td>{task.notes}</td>

  <td>{task.createdOn}</td>

  <td>{task.statusChangedOn}</td>

</tr>

)}
                    </tbody>
                </table>
            </div>
            





        )
    }

}
export default Gettaskbyid;