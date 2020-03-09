package leSuperCoin.model.dao;

public class JpaDaoFactory extends DaoFactory {

    public JpaDaoFactory() {

    }

    @Override
    public JpaDaoAnnonce getAnnonceDao() {
        return JpaDaoAnnonce.getInstance();
    }

    @Override
    public JpaDaoCategorie getCategorieDao() {
        return JpaDaoCategorie.getInstance();
    }

    @Override
    public JpaDaoCritere getCritereDao() {
        return JpaDaoCritere.getInstance();
    }

    @Override
    public JpaDaoPhoto getPhotoDao() {
        return JpaDaoPhoto.getInstance();
    }

    @Override
    public JpaDaoSurCategorie getSurCategorieDao() {
        return JpaDaoSurCategorie.getInstance();
    }

    @Override
    public JpaDaoUser getUserDao() {
        return JpaDaoUser.getInstance();
    }

    @Override
    public JpaDaoValeurCritere getValeurCritereDao() {
        return JpaDaoValeurCritere.getInstance();
    }

}