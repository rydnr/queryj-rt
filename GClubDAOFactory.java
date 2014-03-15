//;-*- mode: java-*-
/*
                        NLP-Games

   Copyright (C) 2006 Ventura24 S.L.

   License details are included in Ventura24 license file.
 */
// Generated using org/acmsl/queryj/dao/BaseDAOFactory.stg at 2013/06/17 06:18
package com.ventura24.nlp.games.dao;

/*
 * Importing some JDK classes.
 */
import java.lang.IllegalAccessException;
import java.lang.InstantiationException;

/*
 * Importing some commons-logging classes.
 */
import org.apache.commons.logging.LogFactory;

/**
 * Is able to create GClubDAO instances,
 * following the Abstract Factory pattern.
 * @author <a href="http://www.acm-sl.org/projects/queryj">QueryJ</a> 
 * @since 2013/06/17 06:18
 */
public abstract class GClubDAOFactory
{
    /**
     * Retrieves a GClubDAOFactory instance.
     * @return such instance.
     */
    @Nullable 
    public static GClubDAOFactory getInstance()
    {
        return getInstance(GamesDAOChooser.getInstance());
    }

    /**
     * Retrieves a GClubDAOFactory instance.
     * @param daoChooser the DAOChooser instance.
     * @return such instance.
     */
    @Nullable 
    protected static GClubDAOFactory getInstance(
        @NotNull final GamesDAOChooser daoChooser)
    {
        GClubDAOFactory result = null;

        String t_strGClubDAOFactoryClassName =
            daoChooser.getGClubDAOFactoryClassName();

        if  (t_strGClubDAOFactoryClassName != null)
        {
            try
            {
                Class t_FactoryClass =
                    Class.forName(
                        t_strGClubDAOFactoryClassName);

                result =
                    (GClubDAOFactory) t_FactoryClass.newInstance();
            }
            catch  (final ClassNotFoundException classNotFoundException)
            {
                try
                {
                    LogFactory.getLog(GClubDAOFactory.class).error(
                        "Cannot find GClubDAOFactory implementation class",
                        classNotFoundException);
                }
                catch  (final Throwable throwable)
                {
                    // class-loading problem.
                }
            }
            catch  (final InstantiationException instantiationException)
            {
                try
                {
                    LogFactory.getLog(GClubDAOFactory.class).error(
                        "Cannot instantiate GClubDAOFactory implementation",
                        instantiationException);
                }
                catch  (final Throwable throwable)
                {
                    // class-loading problem.
                }
            }
            catch  (final IllegalAccessException illegalAccessException)
            {
                try
                {
                    LogFactory.getLog(GClubDAOFactory.class).error(
                        "Cannot access GClubDAOFactory implementation",
                        illegalAccessException);
                }
                catch  (final Throwable throwable)
                {
                    // class-loading problem.
                }
            }
        }
        else
        {
            try
            {
                LogFactory.getLog(GClubDAOFactory.class).error(
                    "GClubDAOFactory implementation not specified");
            }
            catch  (final Throwable throwable)
            {
                // class-loading problem.
            }
        }

        return result;
    }

    /**
     * Creates a G_CLUBS-specific DAO instance.
     * @return such DAO.
     */
    public abstract GClubDAO createGClubDAO();
}
