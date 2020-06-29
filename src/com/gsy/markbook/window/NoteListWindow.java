package com.gsy.markbook.window;

import com.gsy.markbook.data.DataCenter;
import com.gsy.markbook.processor.DefaultSourceData;
import com.gsy.markbook.processor.MDFreeMarkProcessor;
import com.gsy.markbook.processor.Processor;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteListWindow {
    private JButton btnCreate;
    private JButton btnClear;
    private JButton btnClose;
    private JTextField tfTopic;
    private JTable tbContent;
    private JPanel contentPanel;

    private void init() {
        tbContent.setModel(DataCenter.TABLE_MODEL);
        tbContent.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topic = tfTopic.getText();
                String fileName = topic + ".md";
                if (null == topic || "".equals(topic)) {
                    MessageDialogBuilder.yesNo("操作结果", "文档标题没有输入");
                    return;
                }
                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
                if (null != virtualFile) {
                    String path = virtualFile.getPath();
                    String fileFullPath = path + "/" + fileName;
                    Processor processor = new MDFreeMarkProcessor();
                    try {
                        processor.process(new DefaultSourceData(fileFullPath, topic, DataCenter.NOTE_LIST));
                        NotificationGroup notificationGroup = new NotificationGroup("markbook_id",
                                NotificationDisplayType.BALLOON, true);
                        Notification notification = notificationGroup.createNotification("生成文档成功" + fileFullPath, MessageType.INFO);
                        Notifications.Bus.notify(notification);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.reset();
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);
            }
        });
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
