<%@page import="java.util.HashMap"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <s:actionerror theme="bootstrap"/>
        <s:actionmessage theme="bootstrap"/>
        <s:fielderror theme="bootstrap"/>
        <div class="row-fluid" id="divPrepForm">
            <s:form id="formCropPrep" action="savePrep" cssClass="form-horizontal">
                <fieldset>
                    <legend>Formulario de preparación</legend>
                    <div class="row">
                        <div class="span5">
                            <s:hidden name="idCrop"/>
                            <s:hidden name="typeCrop"/>
                            <s:hidden name="actExe"/>
                            <s:hidden name="prep.idPrep"/>
                            <div class="control-group">
                                <label for="formCropPrep_prep_datePrep" class="control-label req">
                                    Fecha de trabajo:
                                </label>
                                <div class="date controls">
                                    <s:date name="prep.datePrep" format="dd/MM/yyyy" var="dateTransformPrep"/>
                                    <s:textfield name="prep.datePrep" value="%{#dateTransformPrep}" readonly="true"/>
                                    <span class="prefix sec">&nbsp;[dd/mm/yyyy]</span>
                                    <span class="add-on"><i class="icon-calendar"></i></span>
                                </div>                          
                            </div>                          
                        </div>                          
                        <div class="span4" style="padding-left: 28px">
                            <div class="control-group">
                                <label for="formCropPrep_prep_depthPrep" class="control-label req">
                                     Profundidad del trabajo (cm): 
                                </label>
                                <div class="controls">
                                    <s:textfield name="prep.depthPrep"/>
                                </div> 
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span5">
                            <div class="control-group">
                                <label for="formCropPrep_prep_preparationsTypes_idPreTyp" class="control-label req">
                                    Tipo de prepación:
                                </label>
                                <div class="controls">
                                    <s:select
                                        name="prep.preparationsTypes.idPreTyp"
                                        list="type_prep_typ" 
                                        listKey="idPreTyp" 
                                        listValue="namePreTyp"            
                                        headerKey="-1" 
                                        headerValue="---"
                                        onchange="showOtherElementPrep(this.value, 'divNewPasses', 'divNewTypePrep')"
                                    />
                                </div>                          
                            </div>                          
                        </div>     
                        <div class="span4 hide" id="divNewPasses" style="padding-left: 28px">
                            <div class="control-group">
                                <label for="formCropPrep_prep_passingsNumberPrep" class="control-label req">
                                    Numero de pases:
                                </label>
                                <div class="controls">
                                    <s:textfield name="prep.passingsNumberPrep"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hide" id="divNewTypePrep">
                        <div class="row">
                            <div class="span5">
                                <div class="control-group">
                                    <label for="formCropPrep_prep_otherPreparationTypePrep" class="control-label req">
                                        Nuevo tipo de preparación:
                                    </label>
                                    <div class="controls radioSelect">
                                        <s:textfield name="prep.otherPreparationTypePrep"/>
                                    </div>                         
                                </div>                         
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span5">
                            <div class="control-group">
                                <label for="formCropPrep_prep_residualsClasification_idResCla" class="control-label req">
                                    Manejo de rastrojos:
                                </label>
                                <div class="controls">
                                    <s:select
                                        name="prep.residualsClasification.idResCla"
                                        list="type_res_clas" 
                                        listKey="idResCla" 
                                        listValue="nameResCla"            
                                        headerKey="-1" 
                                        headerValue="---"
                                        onchange="showOtherElement(this.value, 'divNewManageStub');"
                                    />
                                </div>                         
                            </div>                          
                        </div>   
                        <% String classNewRes="hide"; %>
                        <s:set name="idResidual" value="prep.residualsClasification.idResCla"/>
                        <s:if test="%{#idResidual==1000000}">
                            <% classNewRes = "";%>
                        </s:if>  
                        <div class="span4 <%= classNewRes %>" id="divNewManageStub" style="padding-left: 28px">
                            <div class="control-group">
                                <label for="formCropPrep_prep_otherResidualsManagementPrep" class="control-label req">
                                     Nuevo manejo de rastrojo:
                                </label>
                                <div class="controls">
                                    <s:textfield name="prep.otherResidualsManagementPrep"/>
                                </div>
                            </div>
                        </div>
                    </div>	
                    <script>
                        showOtherElementPrep($("#formCropPrep_prep_preparationsTypes_idPreTyp").val(), 'divNewPasses', 'divNewTypePrep');
                        $("#formCropPrep_prep_datePrep").datepicker({dateFormat: 'dd/mm/yy'});
                        $("#formCropPrep_prep_datePrep").mask("99/99/9999", {placeholder: " "});
                        $("#formCropPrep_prep_depthPrep").numeric({decimal: false, negative: false});
                        $("#formCropPrep_prep_passingsNumberPrep").numeric({decimal: false, negative: false});
                        $("#formCropPrep_prep_depthPrep").val(parsePointSeparated($("#formCropPrep_prep_depthPrep").val())); 
                    </script>
                    <div id="divBtPrep">
                        <sj:submit type="button" cssClass="btn btn-initial btn-large" onclick="addMessageProcess()" targets="divMessage" onCompleteTopics="completePrep" validate="true" validateFunction="validationForm"><i class="icon-save"></i>  Guardar Preparación</sj:submit>
                        <button class="btn btn_default btn-large" onclick="resetForm('formCropPrep'); closeWindow();">Cancelar</button>
                    </div>
                </fieldset>
            </s:form>	
            <script>                
                $.subscribe('completePrep', function(event, data) {             
                    completeFormGetting('dialog-form', 'formCropPrep', 'divPrep', event.originalEvent.request.responseText);
                    setTimeout(function() {
//                        showInfo("searchField.action?page="+$("#formField_page").val(), "divConListFields");
                        showInfo("/aeps-plataforma-mvn/crop/searchPrep.action?idCrop="+$("#formCropPrep_idCrop").val(), "divListPrep");
                    }, 2000);
                });
            </script>
        </div>
        <div class="row-fluid" id="divListPrepForm"></div>
    </body>
</html>