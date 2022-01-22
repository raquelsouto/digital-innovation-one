import { Router, Request, Response, NextFunction, response } from 'express';
import { StatusCodes } from 'http-status-codes';
import userRepository from '../repository/user.repository';

const usersRoute = Router();

usersRoute.get('/users', async (req: Request, res: Response, next: NextFunction) => {
    const users = await userRepository.findAllUser();
    res.status(200).json(users);
});

usersRoute.get('/users/:id', async (req: Request <{ id: string }>, res: Response, next: NextFunction) => {
    const id = req.params.id;
    const user = await userRepository.findById(id);
    res.status(StatusCodes.OK).send(user);
});

usersRoute.post('/users', async(req: Request <{ id: string }>, res: Response, next: NextFunction) => {
    const newUser = req.body;
    const id = await userRepository.create(newUser);
    res.status(StatusCodes.CREATED).send(id);
});

usersRoute.put('/users/:id', async (req: Request <{ id: string }>, res: Response, next: NextFunction) => {
    const id = req.params.id;
    const modifiedUser = req.body;
    modifiedUser.id = id;

    await userRepository.update(modifiedUser);

    res.status(StatusCodes.OK).send(modifiedUser);
});

usersRoute.delete('/users/:id', async (req: Request <{ id: string }>, res: Response, next: NextFunction) => {
    const id = req.params.id;
    
    await userRepository.remove(id);
    res.sendStatus(StatusCodes.OK);
});

export default usersRoute;