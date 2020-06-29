package com.gsy.markbook.processor;


import freemarker.template.Template;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public abstract class AbstractFreeMarkProcessor implements Processor {

    protected abstract Template getTemplete() throws IOException;

    protected abstract Object getModel(SourceNoteData sourceNoteData);

    protected abstract Writer getWriter(SourceNoteData sourceNoteData) throws FileNotFoundException, UnsupportedEncodingException, Exception;

    @Override
    public final void process(SourceNoteData sourceNoteData) throws Exception {
        Template templete = getTemplete();
        Object model = getModel(sourceNoteData);
        Writer writer = getWriter(sourceNoteData);
        templete.process(model, writer);

    }
}
