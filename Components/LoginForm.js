import React,{Component} from "react";
import axios from "axios";

class LoginForm extends Component{
    constructor(props){
        super(props)
        this.state={
            emailid:'',
            password:''

        }
        this.changeHandler=this.changeHandler.bind(this)
        this.submitHandler=this.submitHandler.bind(this)
    }
    changeHandler(e){
        this.setState({
            [e.target.name]:e.target.value})
    }
    submitHandler(e){
        e.preventDefault()
        console.log(this.state)
        axios.post("http://localhost:8080/validateuser",this.state)
        .then(response=>{
            console.log(response)
        }).catch(error=>{console.log(error)})
    }

    render(){
        const{emailid,password}=this.state
        return(
            <div>
                <div>
                <h2 style={{"color":"red","backgroundColor":"aquamarine","textAlign":"center","opacity":"0.8","margin":"10px 400px 10px"}}>Login</h2>
                </div>
                
                <form onSubmit={this.submitHandler} style={{"textAlign":"center","backgroundColor":"silver","opacity":"0.8","margin":"10px 400px 10px "}}>
                    <div>
                    emailid:
                        <input type="email" name="emailid" value={emailid} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <div>
                    password:
                        <input type="password" name="password" value={password} onChange={this.changeHandler}/>
                    </div>
                    <br></br>
                    <button type="submit">Submit</button>
                    
                </form>
            </div>
        )
    }
    
}

export default LoginForm;