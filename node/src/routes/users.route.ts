import { Router, Request, Response, NextFunction, response } from 'express';
import { StatusCodes } from 'http-status-codes';

const usersRoute = Router();

usersRoute.get('/users', (req: Request, res: Response, next: NextFunction) => {
    const users = [{ name: 'Raquel' }];
    res.status(200).json(users);
});

usersRoute.get('/users/:id', (req: Request <{ id: string }>, res: Response, next: NextFunction) => {
    const id = req.params.id;
    res.status(StatusCodes.OK).send({ id });
});

usersRoute.post('/users', (req: Request <{ id: string }>, res: Response, next: NextFunction) => {
    const newUser = req.body;
    console.log(newUser);
    res.status(StatusCodes.CREATED).send();
});


export default usersRoute;