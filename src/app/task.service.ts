import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import { Observable } from "rxjs";
import { Task } from "./Task";
import { User } from "./User";
@Injectable({
    providedIn: 'root'
})
export class TaskServices {


    baseUrl: string = "http://localhost:8080"
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json', 'Authorization': 'my-auth-token'
        })
    };
    constructor(private httpClient: HttpClient) { }

    gettaskList(): Observable<any> {
        return this.httpClient.get(`${this.baseUrl}/listtask`, this.httpOptions);
    }
    createtask(tas: Task) {
        return this.httpClient
            .post(`${this.baseUrl}/addtask`, tas);
    }
    deletetask(id: number): Observable<any> {
        return this.httpClient
            .delete(`${this.baseUrl}/deletetask/${id}`,{responseType:'text'})
    }
    gettask(id: number): Observable<any> {
        return this.httpClient.get(`${this.baseUrl}/gettask/${id}`, this.httpOptions);
    }

    updatetask(task_Id: number,value: any): Observable<Object> {
        return this.httpClient.put(`${this.baseUrl}/updatetask/${task_Id}`, value);
    }
    validateuser(us: User) {
        return this.httpClient
            .post(`${this.baseUrl}/validateuser`, us);
    }
    adduser(use: User) {
        return this.httpClient
            .post(`${this.baseUrl}/adduser`, use);
    }
    assigntask(value: any): Observable<Object> {
        return this.httpClient.put(`${this.baseUrl}/assigntask`, value);
    }
    updatepriority(value: any): Observable<Object> {
        return this.httpClient.put(`${this.baseUrl}/updatepriority`, value);
    }
    updatebookmark(value: any): Observable<Object> {
        return this.httpClient.put(`${this.baseUrl}/updatebookmark`, value);
    }
    updatenotes(value: any): Observable<Object> {
        return this.httpClient.put(`${this.baseUrl}/updatenotes`, value);
    }

}