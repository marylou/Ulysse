/*
 *
 * Qualipso Factory
 * Copyright (C) 2006-2010 INRIA
 * http://www.inria.fr - molli@loria.fr
 *
 * This software is free software; you can redistribute it and/or
 * modify it under the terms of LGPL. See licenses details in LGPL.txt
 *
 * Initial authors :
 *
 * Jérôme Blanchard / INRIA
 * Pascal Molli / Nancy Université
 * Gérald Oster / Nancy Université
 * Christophe Bouthier / INRIA
 * 
 */
package org.qualipso.factory.test.entity;

import com.bm.testsuite.BaseEntityFixture;

import org.qualipso.factory.core.entity.File;


/**
 * @author Jerome Blanchard (jayblanc@gmail.com)
 * @date 28 August 2009
 */
public class FileTest extends BaseEntityFixture<File> {
    public FileTest() {
        super(File.class);
    }
}
