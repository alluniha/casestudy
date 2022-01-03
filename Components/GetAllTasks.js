import React, { Component } from "react";

import axios from "axios";



class GetAllTasks extends Component{

     

     

    constructor(props){

        super(props)

        this.state ={

            tasks :[]

        }

        this.handleClick = this.handleClick.bind(this)

    }

    handleClick(){

        axios.get('http://localhost:8080/tasks')

        .then(response=>{

            this.setState({tasks:response.data})

            console.log(response.data)

        })

   

    }

    render(){



        const {tasks} = this.state



        return(
            <div >
                <h3>TaskList</h3>
                <button className='button' onClick={this.handleClick}> TaskList</button>
                {this.state.tasks.map(task => (<h3>
                    Task_ID: {task.taskID} <br />
                    Owner_ID: {task.ownerID} <br />
                    Creator_ID: {task.creatorID} <br />
                    Name: {task.name} <br />
                    Description: {task.description} <br />
                    Status: {task.status} <br />
                    Priority: {task.priority} <br />
                    Notes: {task.notes} <br />
                    IsBookmarked: {task.isBookmarked} <br />
                    Created_On: {task.createdOn} <br />
                    Status_Changed_On: {task.statusChangedOn} <br />
                 
                </h3>))}
            </div>
        )
    }
}
export default GetAllTasks;