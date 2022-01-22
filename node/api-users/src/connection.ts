import { Pool } from 'pg';

const connectionString = 'postgres://ymexriau:DWjDYuFUsJXCVqgdQu-wz_afJV_Tdvr_@kesavan.db.elephantsql.com/ymexriau';

const db = new Pool({ connectionString });

export default db;