import db from "../connection";
import User from "../model/user.model";

class UserRepository {

    async findAllUser(): Promise<User[]> {
        const query = `SELECT id, username FROM application_user`;

        const { rows } = await db.query<User>(query);
        return rows || [];
    }

    async findById(id:string): Promise<User> {
        const query = `SELECT id, username FROM application_user WHERE id = $1`

        const values = [id];

        const { rows } = await db.query<User>(query, values);
        const [ user ] = rows;
        
        return user;
    } 

    async create(user: User): Promise<string> {
        const script = `INSERT INTO application_user(username, password) VALUES($1, crypt($2, 'my_salt')) RETURNING ID`;

        const values = [user.username, user.password];

        const { rows } = await db.query<{id: string}>(script, values);
        const [newUser] = rows;
        return newUser.id;
    }

    async update(user: User): Promise<void> {
        const script = `UPDATE application_user 
                        SET username = $1,
                            password = crypt($2, 'my_salt')
                        WHERE id = $3`;

        const values = [user.username, user.password, user.id];
        const { rows } = await db.query<{id: string}>(script, values);
    }

    async remove(id: string): Promise<void> {
        const script = `DELETE FROM application_user WHERE id = $1`;

        const values = [id];
        await db.query(script, values);
    }

}

export default new UserRepository();