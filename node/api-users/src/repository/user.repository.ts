import db from "../connection";
import User from "../model/user.model";

class UserRepository {

    async findAllUser(): Promise<User[]> {
        const query = `SELECT id, username FROM application_user`;

        const result = await db.query<User>(query);
        const rows = result.rows;
        return rows || [];
    }
}

export default new UserRepository();